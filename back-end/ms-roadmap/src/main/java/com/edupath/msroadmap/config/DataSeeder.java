package com.edupath.msroadmap.config;

import com.edupath.msroadmap.model.ExperienceLevel;
import com.edupath.msroadmap.model.InterestArea;
import com.edupath.msroadmap.model.Roadmap;
import com.edupath.msroadmap.repository.RoadmapRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RoadmapRepository roadmapRepository;

    public DataSeeder(RoadmapRepository roadmapRepository) {
        this.roadmapRepository = roadmapRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roadmapRepository.count() == 0) {
            roadmapRepository.saveAll(List.of(
                    new Roadmap("683cad5cd95ded76dcc10682", "Lógica de Programação", "Aprenda os fundamentos da lógica de programação.", InterestArea.BASE, ExperienceLevel.BEGINNER),
                    new Roadmap("683cad5cd95ded76dcc10683", "Desenvolvimento Front-End", "Construa interfaces web com HTML, CSS e JavaScript.", InterestArea.FRONTEND, ExperienceLevel.BEGINNER),
                    new Roadmap("683cad5cd95ded76dcc10684", "Desenvolvimento Back-End", "Crie APIs e sistemas robustos no servidor.", InterestArea.BACKEND, ExperienceLevel.BEGINNER),
                    new Roadmap("683cad5cd95ded76dcc10685", "Desenvolvimento Mobile", "Desenvolva aplicativos móveis para Android e iOS.", InterestArea.MOBILE, ExperienceLevel.BEGINNER),
                    new Roadmap("683cad5cd95ded76dcc10686", "DevOps", "Automatize e integre processos de desenvolvimento e operações.", InterestArea.DEVOPS, ExperienceLevel.BEGINNER)
            ));
            System.out.println(">>> Roadmaps inseridos com sucesso!");
        }
    }
}
