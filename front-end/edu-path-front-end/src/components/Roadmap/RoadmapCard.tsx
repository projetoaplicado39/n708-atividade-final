import React from "react";
import type { Roadmap } from "../../types/roadmap";

interface RoadmapCardProps {
  roadmap: Roadmap;
}

export default function RoadmapCard({ roadmap }: RoadmapCardProps) {
  return (
    <div className="bg-white dark:bg-gray-800 rounded-lg shadow-md hover:shadow-lg transition-shadow duration-200">
      <div className="p-6">
        <h2 className="text-xl font-semibold text-gray-900 dark:text-white mb-2">
          {roadmap.title}
        </h2>
        <p className="text-gray-600 dark:text-gray-300 mb-4 line-clamp-2">
          {roadmap.description}
        </p>
        <div className="flex gap-2">
          <span className="inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium bg-primary-100 text-primary-800 dark:bg-primary-900 dark:text-primary-200">
            {roadmap.interestArea}
          </span>
          <span className="inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium bg-primary-100 text-primary-800 dark:bg-primary-900 dark:text-primary-200">
            {roadmap.experienceLevel}
          </span>
        </div>
      </div>
    </div>
  );
}
