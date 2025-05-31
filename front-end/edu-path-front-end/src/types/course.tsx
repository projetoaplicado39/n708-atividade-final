export type Course = {
  id: string;
  title: string;
  description: string;
  url: string;
  provider: string;
  duration: string;
  difficultyLevel: "BEGINNER" | "INTERMEDIATE" | "ADVANCED";
};
