import axios from "axios";
import type { Roadmap, RoadmapStep } from "../types/roadmap";

const API_URL = "http://localhost:8083/api/v1";

export const roadmapService = {
  getAllRoadmaps: async (): Promise<Roadmap[]> => {
    const response = await axios.get(`${API_URL}/roadmaps`);
    return response.data;
  },

  getRoadmapById: async (id: string): Promise<Roadmap> => {
    const response = await axios.get(`${API_URL}/roadmaps/${id}`);
    return response.data;
  },

  getRoadmapSteps: async (roadmapId: string): Promise<RoadmapStep[]> => {
    const response = await axios.get(`${API_URL}/roadmaps/${roadmapId}/steps`);
    return response.data;
  },

  updateStepProgress: async (
    roadmapId: string,
    stepId: string,
    completed: boolean
  ) => {
    const response = await axios.put(`${API_URL}/users/progress`, {
      roadmapId,
      stepId,
      completed,
    });
    return response.data;
  },
};
