// filepath: src/pages/Courses/CourseDetail.tsx
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import type { Course } from "../../types/course";
import { courseService } from "../../services/courseService";

export default function CourseDetail() {
  const { id } = useParams<{ id: string }>();
  const [course, setCourse] = useState<Course | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    if (id) {
      loadCourse();
    }
  }, [id]);

  const loadCourse = async () => {
    try {
      setLoading(true);
      const data = await courseService.getCourseById(id!);
      setCourse(data);
    } catch (err) {
      setError("Falha ao carregar o curso. Tente novamente mais tarde.");
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <div className="flex justify-center items-center min-h-[400px]">
        <div className="text-primary-600 dark:text-primary-400">
          Carregando...
        </div>
      </div>
    );
  }

  if (error || !course) {
    return (
      <div className="flex justify-center items-center min-h-[400px]">
        <div className="text-red-600 dark:text-red-400">
          {error || "Curso não encontrado"}
        </div>
      </div>
    );
  }

  return (
    <div className="max-w-4xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
      <div className="bg-white dark:bg-gray-800 rounded-lg shadow-lg p-6">
        <h1 className="text-3xl font-bold text-gray-900 dark:text-white mb-4">
          {course.title}
        </h1>

        <div className="prose dark:prose-invert max-w-none mb-6">
          <p>{course.description}</p>
        </div>

        <div className="grid grid-cols-2 gap-4 mb-6">
          <div>
            <h3 className="text-sm font-medium text-gray-500 dark:text-gray-400">
              Provedor
            </h3>
            <p className="mt-1 text-lg text-gray-900 dark:text-white">
              {course.provider}
            </p>
          </div>
          <div>
            <h3 className="text-sm font-medium text-gray-500 dark:text-gray-400">
              Duração
            </h3>
            <p className="mt-1 text-lg text-gray-900 dark:text-white">
              {course.duration}
            </p>
          </div>
        </div>

        <div className="flex justify-end">
          <a
            href={course.url}
            target="_blank"
            rel="noopener noreferrer"
            className="inline-flex items-center px-6 py-3 border border-transparent text-base font-medium rounded-md shadow-sm text-white bg-primary-600 hover:bg-primary-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-primary-500 dark:hover:bg-primary-500"
          >
            Iniciar Curso
          </a>
        </div>
      </div>
    </div>
  );
}
