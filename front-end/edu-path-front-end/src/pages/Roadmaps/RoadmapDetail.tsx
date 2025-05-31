import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import type { Roadmap, RoadmapStep } from "../../types/roadmap";
import { roadmapService } from "../../services/roadmapService";
import RoadmapStepList from "../../components/Roadmap/RoadmapStepList";

export default function RoadmapDetail() {
  const { id } = useParams<{ id: string }>();
  const [roadmap, setRoadmap] = useState<Roadmap | null>(null);
  const [steps, setSteps] = useState<RoadmapStep[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    if (id) {
      loadRoadmapAndSteps();
    }
  }, [id]);

  const loadRoadmapAndSteps = async () => {
    try {
      setLoading(true);
      const [roadmapData, stepsData] = await Promise.all([
        roadmapService.getRoadmapById(id!),
        roadmapService.getRoadmapSteps(id!),
      ]);
      setRoadmap(roadmapData);
      setSteps(stepsData);
    } catch (err) {
      setError("Failed to load roadmap details");
    } finally {
      setLoading(false);
    }
  };

  const handleStepComplete = async (stepId: string, completed: boolean) => {
    try {
      await roadmapService.updateStepProgress(id!, stepId, completed);
      setSteps(
        steps.map((step) =>
          step.id === stepId ? { ...step, completed } : step
        )
      );
    } catch (err) {
      setError("Failed to update progress");
    }
  };

  if (loading) {
    return (
      <div className="flex justify-center items-center min-h-[400px]">
        <div className="text-primary-600 dark:text-primary-400">Loading...</div>
      </div>
    );
  }

  if (error || !roadmap) {
    return (
      <div className="flex justify-center items-center min-h-[400px]">
        <div className="text-red-600 dark:text-red-400">
          {error || "Roadmap not found"}
        </div>
      </div>
    );
  }

  return (
    <div className="max-w-4xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
      <div className="mb-8">
        <h1 className="text-3xl font-bold text-gray-900 dark:text-white mb-4">
          {roadmap.title}
        </h1>
        <p className="text-gray-600 dark:text-gray-300">
          {roadmap.description}
        </p>
        <div className="mt-4 flex gap-4">
          <span className="inline-flex items-center px-3 py-1 rounded-full text-sm font-medium bg-primary-100 text-primary-800 dark:bg-primary-900 dark:text-primary-200">
            {roadmap.interestArea}
          </span>
          <span className="inline-flex items-center px-3 py-1 rounded-full text-sm font-medium bg-primary-100 text-primary-800 dark:bg-primary-900 dark:text-primary-200">
            {roadmap.experienceLevel}
          </span>
        </div>
      </div>

      <RoadmapStepList steps={steps} onStepComplete={handleStepComplete} />
    </div>
  );
}
