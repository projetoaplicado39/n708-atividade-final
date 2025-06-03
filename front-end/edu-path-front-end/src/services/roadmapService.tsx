/*import axios from "axios";
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
*/

import axios from "axios";
import type { Roadmap, RoadmapStep } from "../types/roadmap";
import type { Course } from "../types/course";

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

  getCoursesByStep: async (
    roadmapId: string,
    stepId: string
  ): Promise<Course[]> => {
    const response = await axios.get(
      `${API_URL}/roadmaps/${roadmapId}/steps/${stepId}/courses`
    );
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

  getCoursesByStepId: async (roadmapId: string, stepId: string) => {
    const response = await axios.get(
      `${API_URL}/roadmaps/${roadmapId}/steps/${stepId}/courses`
    );
    return response.data;
  },
};
