import React, { useState, useEffect } from "react";
import type { RoadmapStep } from "../../types/roadmap";
import { roadmapService } from "../../services/roadmapService";

interface RoadmapStepItemProps {
  roadmapId: string;
  step: RoadmapStep;
  index: number;
  onStepComplete: (stepId: string, completed: boolean) => void;
}

export default function RoadmapStepItem({
  roadmapId,
  step,
  index,
  onStepComplete,
}: RoadmapStepItemProps) {
  const [expanded, setExpanded] = useState(false);
  const [courses, setCourses] = useState([]);
  const [loadingCourses, setLoadingCourses] = useState(false);

  const toggleExpand = async () => {
    setExpanded(!expanded);

    if (!expanded && courses.length === 0) {
      // Busca cursos apenas ao expandir pela primeira vez
      setLoadingCourses(true);
      try {
        const response = await roadmapService.getCoursesByStepId(
          roadmapId,
          step.id
        );
        setCourses(response);
      } catch (error) {
        console.error("Erro ao carregar cursos:", error);
      } finally {
        setLoadingCourses(false);
      }
    }
  };

  return (
    <div
      className="bg-white dark:bg-gray-800 rounded-lg shadow p-6 cursor-pointer transition hover:shadow-lg"
      onClick={toggleExpand}
    >
      <div className="flex items-start justify-between">
        <div className="flex items-center gap-4">
          <div className="w-8 h-8 rounded-full bg-primary-100 dark:bg-primary-900 flex items-center justify-center text-primary-600 dark:text-primary-300">
            {index + 1}
          </div>
          <div>
            <h3 className="text-lg font-medium text-gray-900 dark:text-white">
              {step.title}
            </h3>
            <p className="text-gray-600 dark:text-gray-300">
              {step.description}
            </p>
          </div>
        </div>

        <label
          className="relative inline-flex items-center cursor-pointer"
          onClick={(e) => e.stopPropagation()} // evita disparar expand
        >
          <input
            type="checkbox"
            checked={step.completed}
            onChange={(e) => onStepComplete(step.id, e.target.checked)}
            className="sr-only peer"
          />
          <div className="w-11 h-6 bg-gray-200 peer-focus:outline-none peer-focus:ring-4 peer-focus:ring-primary-300 dark:peer-focus:ring-primary-800 rounded-full peer dark:bg-gray-700 peer-checked:after:translate-x-full peer-checked:after:border-white after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-white after:border-gray-300 after:border after:rounded-full after:h-5 after:w-5 after:transition-all dark:border-gray-600 peer-checked:bg-primary-600"></div>
        </label>
      </div>

      {expanded && (
        <div className="mt-4">
          {loadingCourses ? (
            <p className="text-primary-600 dark:text-primary-400">
              Carregando cursos...
            </p>
          ) : courses.length === 0 ? (
            <p className="text-gray-500">Nenhum curso associado.</p>
          ) : (
            <ul className="space-y-2">
              {courses.map((course: any) => (
                <li
                  key={course.id}
                  className="border p-3 rounded-lg dark:border-gray-700"
                >
                  <a
                    href={course.url}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="text-primary-600 dark:text-primary-400 hover:underline"
                  >
                    {course.title}
                  </a>
                  <p className="text-sm text-gray-600 dark:text-gray-300">
                    {course.provider} • {course.duration} •{" "}
                    {course.difficultyLevel}
                  </p>
                </li>
              ))}
            </ul>
          )}
        </div>
      )}
    </div>
  );
}
