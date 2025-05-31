import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import type { Roadmap } from "../../types/roadmap";
import { roadmapService } from "../../services/roadmapService";
import RoadmapCard from "../../components/Roadmap/RoadmapCard";

export default function RoadmapList() {
  const [roadmaps, setRoadmaps] = useState<Roadmap[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    loadRoadmaps();
  }, []);

  const loadRoadmaps = async () => {
    try {
      setLoading(true);
      const data = await roadmapService.getAllRoadmaps();
      setRoadmaps(data);
    } catch (err) {
      setError("Failed to load roadmaps");
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <div className="flex justify-center items-center min-h-[400px]">
        <div className="text-primary-600 dark:text-primary-400">Loading...</div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="flex justify-center items-center min-h-[400px]">
        <div className="text-red-600 dark:text-red-400">{error}</div>
      </div>
    );
  }

  return (
    <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
      <h1 className="text-3xl font-bold text-gray-900 dark:text-white mb-8">
        Learning Roadmaps
      </h1>

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {roadmaps.map((roadmap) => (
          <Link key={roadmap.id} to={`/roadmaps/${roadmap.id}`}>
            <RoadmapCard roadmap={roadmap} />
          </Link>
        ))}
      </div>
    </div>
  );
}
