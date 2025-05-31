export type RoadmapStep = {
  id: string;
  roadmapId: string;
  title: string;
  description: string;
  orderIndex: number;
  completed?: boolean;
};

export type Roadmap = {
  id: string;
  title: string;
  description: string;
  interestArea: string;
  experienceLevel: "BEGINNER" | "INTERMEDIATE" | "ADVANCED";
  steps?: RoadmapStep[];
};
