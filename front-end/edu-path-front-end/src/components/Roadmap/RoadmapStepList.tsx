import React from "react";
import type { RoadmapStep } from "../../types/roadmap";
import RoadmapStepItem from "./RoadmapStepItem";

interface RoadmapStepListProps {
  roadmapId: string;
  steps: RoadmapStep[];
  onStepComplete: (stepId: string, completed: boolean) => void;
}

export default function RoadmapStepList({
  roadmapId,
  steps,
  onStepComplete,
}: RoadmapStepListProps) {
  return (
    <div className="space-y-4">
      {steps.map((step, index) => (
        <RoadmapStepItem
          key={step.id}
          roadmapId={roadmapId}
          step={step}
          index={index}
          onStepComplete={onStepComplete}
        />
      ))}
    </div>
  );
}
