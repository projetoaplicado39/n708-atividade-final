import axios from "axios";
import type { Course } from "../types/course";

const API_URL = "http://localhost:8084/api/v1";

export const courseService = {
  getAllCourses: async (): Promise<Course[]> => {
    const response = await axios.get(`${API_URL}/courses`);
    return response.data;
  },

  getCourseById: async (id: string): Promise<Course> => {
    const response = await axios.get(`${API_URL}/courses/${id}`);
    return response.data;
  },

  getCoursesByRoadmap: async (roadmapId: string): Promise<Course[]> => {
    const response = await axios.get(`${API_URL}/courses/roadmap/${roadmapId}`);
    return response.data;
  },
};
