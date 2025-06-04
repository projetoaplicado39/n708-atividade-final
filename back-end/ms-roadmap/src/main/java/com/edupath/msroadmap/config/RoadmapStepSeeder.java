package com.edupath.msroadmap.config;

import com.edupath.msroadmap.model.Roadmap;
import com.edupath.msroadmap.model.RoadmapStep;
import com.edupath.msroadmap.repository.RoadmapRepository;
import com.edupath.msroadmap.repository.RoadmapStepRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoadmapStepSeeder implements CommandLineRunner {

    private final RoadmapRepository roadmapRepository;
    private final RoadmapStepRepository roadmapStepRepository;

    public RoadmapStepSeeder(RoadmapRepository roadmapRepository, RoadmapStepRepository roadmapStepRepository) {
        this.roadmapRepository = roadmapRepository;
        this.roadmapStepRepository = roadmapStepRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (roadmapStepRepository.count() == 0) {
            List<Roadmap> roadmaps = roadmapRepository.findAll();

            for (Roadmap roadmap : roadmaps) {
                List<RoadmapStep> steps = new ArrayList<>();

                switch (roadmap.getInterestArea()) {
                    case BASE -> {
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff1059", roadmap.getId(), "Introdução à Lógica de Programação", "Conceitos básicos de lógica e algoritmos", 1));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff105a", roadmap.getId(), "Controle de Fluxo", "Estruturas condicionais e de repetição", 2));
                    }
                    case FRONTEND -> {
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff105b", roadmap.getId(), "Introdução à Lógica de Programação", "Conceitos básicos de lógica e algoritmos", 1));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff105c", roadmap.getId(), "Controle de Fluxo", "Estruturas condicionais e de repetição", 2));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff105d", roadmap.getId(), "Git e Controle de Versão", "Versionamento de código com Git", 3));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff105e", roadmap.getId(), "HTML, CSS e JavaScript", "Fundamentos do desenvolvimento web", 4));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff105f", roadmap.getId(), "Framework Front-end", "Uso de frameworks como React ou Vue.js", 5));
                    }
                    case BACKEND -> {
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff1060", roadmap.getId(), "Introdução à Lógica de Programação", "Conceitos básicos de lógica e algoritmos", 1));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff1061", roadmap.getId(), "Controle de Fluxo", "Estruturas condicionais e de repetição", 2));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff1062", roadmap.getId(), "Git e Controle de Versão", "Versionamento de código com Git", 3));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff1063", roadmap.getId(), "Fundamentos de APIs", "Como criar e consumir APIs", 4));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff1064", roadmap.getId(), "Banco de Dados", "Modelagem e integração com bancos de dados", 5));
                    }
                    case MOBILE -> {
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff1065", roadmap.getId(), "Introdução à Lógica de Programação", "Conceitos básicos de lógica e algoritmos", 1));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff1066", roadmap.getId(), "Controle de Fluxo", "Estruturas condicionais e de repetição", 2));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff1067", roadmap.getId(), "Git e Controle de Versão", "Versionamento de código com Git", 3));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff1068", roadmap.getId(), "Fundamentos de APIs", "Como criar e consumir APIs", 4));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff1069", roadmap.getId(), "Desenvolvimento Mobile Nativo", "Criando apps nativos para Android e iOS", 5));
                    }
                    case DEVOPS -> {
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff106a", roadmap.getId(), "Git e Controle de Versão", "Versionamento de código com Git", 1));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff106b", roadmap.getId(), "CI/CD com DevOps", "Integração e entrega contínua", 2));
                        steps.add(new RoadmapStep("683d7c45c0adeb1f83ff106c", roadmap.getId(), "Monitoramento e Logs", "Observabilidade em sistemas de produção", 3));
                    }
                }
                roadmapStepRepository.saveAll(steps);
            }
            System.out.println(">>> RoadmapSteps inseridos com sucesso!");
        }
    }
}
