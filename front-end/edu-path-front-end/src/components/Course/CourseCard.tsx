import React from "react";
import type { Course } from "../../types/course";

interface CourseCardProps {
  course: Course;
}

const difficultyColors = {
  BEGINNER: "bg-green-100 text-green-800 dark:bg-green-900 dark:text-green-200",
  INTERMEDIATE:
    "bg-yellow-100 text-yellow-800 dark:bg-yellow-900 dark:text-yellow-200",
  ADVANCED: "bg-red-100 text-red-800 dark:bg-red-900 dark:text-red-200",
};

export default function CourseCard({ course }: CourseCardProps) {
  return (
    <div className="bg-white dark:bg-gray-800 rounded-lg shadow-md hover:shadow-lg transition-shadow duration-200">
      <div className="p-6">
        <h2 className="text-xl font-semibold text-gray-900 dark:text-white mb-2">
          {course.title}
        </h2>

        <p className="text-gray-600 dark:text-gray-300 mb-4 line-clamp-3">
          {course.description}
        </p>

        <div className="flex items-center justify-between mb-4">
          <span className="text-sm text-gray-500 dark:text-gray-400">
            {course.provider}
          </span>
          <span className="text-sm text-gray-500 dark:text-gray-400">
            {course.duration}
          </span>
        </div>

        <div className="flex items-center justify-between">
          <span
            className={`inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium ${
              difficultyColors[course.difficultyLevel]
            }`}
          >
            {course.difficultyLevel}
          </span>

          <a
            href={course.url}
            target="_blank"
            rel="noopener noreferrer"
            className="inline-flex items-center px-4 py-2 border border-transparent text-sm font-medium rounded-md shadow-sm text-white bg-primary-600 hover:bg-primary-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-primary-500 dark:hover:bg-primary-500"
          >
            Acessar Curso
          </a>
        </div>
      </div>
    </div>
  );
}
