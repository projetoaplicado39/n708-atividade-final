import React from "react";
import type { RoadmapStep } from "../../types/roadmap";

interface RoadmapStepListProps {
  steps: RoadmapStep[];
  onStepComplete: (stepId: string, completed: boolean) => void;
}

export default function RoadmapStepList({
  steps,
  onStepComplete,
}: RoadmapStepListProps) {
  return (
    <div className="space-y-4">
      {steps.map((step, index) => (
        <div
          key={step.id}
          className="bg-white dark:bg-gray-800 rounded-lg shadow p-6"
        >
          <div className="flex items-start gap-4">
            <div className="flex-shrink-0">
              <div className="w-8 h-8 rounded-full bg-primary-100 dark:bg-primary-900 flex items-center justify-center text-primary-600 dark:text-primary-300">
                {index + 1}
              </div>
            </div>
            <div className="flex-grow">
              <h3 className="text-lg font-medium text-gray-900 dark:text-white">
                {step.title}
              </h3>
              <p className="mt-1 text-gray-600 dark:text-gray-300">
                {step.description}
              </p>
            </div>
            <div className="flex-shrink-0">
              <label className="relative inline-flex items-center cursor-pointer">
                <input
                  type="checkbox"
                  checked={step.completed}
                  onChange={(e) => onStepComplete(step.id, e.target.checked)}
                  className="sr-only peer"
                />
                <div className="w-11 h-6 bg-gray-200 peer-focus:outline-none peer-focus:ring-4 peer-focus:ring-primary-300 dark:peer-focus:ring-primary-800 rounded-full peer dark:bg-gray-700 peer-checked:after:translate-x-full peer-checked:after:border-white after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-white after:border-gray-300 after:border after:rounded-full after:h-5 after:w-5 after:transition-all dark:border-gray-600 peer-checked:bg-primary-600"></div>
              </label>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}
