package com.edupath.mscourse.config;

import com.edupath.mscourse.model.Course;
import com.edupath.mscourse.model.DifficultyLevel;
import com.edupath.mscourse.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseDataSeeder implements CommandLineRunner {

    private final CourseRepository courseRepository;

    public CourseDataSeeder(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (courseRepository.count() == 0) {
            List<Course> courses = List.of(
                    new Course("683d942a34268a3db560f76e", "Introdução à Lógica de Programação",
                            "Curso básico de algoritmos e lógica",
                            "https://www.cursoemvideo.com/course/curso-de-algoritmo/",
                            "Curso em Vídeo", "40h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff1059")),

                    new Course("683d942a34268a3db560f76f", "Lógica de Programação",
                            "Fundamentos da lógica aplicada à programação",
                            "https://www.ev.org.br/cursos/logica-de-programacao",
                            "Fundação Bradesco - Escola Virtual", "15h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff1059", "683d7c45c0adeb1f83ff105b",
                                    "683d7c45c0adeb1f83ff1060", "683d7c45c0adeb1f83ff1065")),

                    new Course("683d942a34268a3db560f770", "Introdução à Programação",
                            "Conceitos básicos de programação e algoritmos",
                            "https://www.primecursos.com.br/introducao-a-programacao/",
                            "Prime Cursos", "35h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff1059")),

                    new Course("683d942a34268a3db560f771", "Estruturas de Controle em Algoritmos",
                            "Estruturas condicionais e de repetição",
                            "https://www.cursoemvideo.com/course/curso-de-algoritmo/",
                            "Curso em Vídeo", "20h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff105a", "683d7c45c0adeb1f83ff105c",
                                    "683d7c45c0adeb1f83ff1061", "683d7c45c0adeb1f83ff1066")),

                    new Course("683d942a34268a3db560f772", "Algoritmos e Estruturas de Dados",
                            "Fundamentos de algoritmos com controle de fluxo",
                            "https://www.ev.org.br/cursos/algoritmos-e-estruturas-de-dados",
                            "Fundação Bradesco - Escola Virtual", "25h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff105a")),

                    new Course("683d942a34268a3db560f773", "JavaScript para Iniciantes",
                            "Fundamentos de JavaScript incluindo estruturas de controle",
                            "https://www.cursoemvideo.com/course/javascript/",
                            "Curso em Vídeo", "40h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff105c", "683d7c45c0adeb1f83ff105e")),

                    new Course("683d942a34268a3db560f774", "Curso de Git e GitHub",
                            "Versionamento de código com Git e GitHub",
                            "https://www.cursoemvideo.com/course/curso-de-git-e-github/",
                            "Curso em Vídeo", "20h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff105d", "683d7c45c0adeb1f83ff1062",
                                    "683d7c45c0adeb1f83ff1067", "683d7c45c0adeb1f83ff106a")),

                    new Course("683d942a34268a3db560f775", "Controle de Versões com Git",
                            "Fundamentos do Git para controle de versão",
                            "https://www.ev.org.br/cursos/git-e-controle-de-versoes",
                            "Fundação Bradesco - Escola Virtual", "15h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff105d", "683d7c45c0adeb1f83ff1062",
                                    "683d7c45c0adeb1f83ff1067")),

                    new Course("683d942a34268a3db560f776", "Git e GitHub Essencial",
                            "Curso completo de Git e GitHub",
                            "https://www.primecursos.com.br/git-github/",
                            "Prime Cursos", "25h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff105d")),

                    new Course("683d942a34268a3db560f777", "Curso de HTML5 e CSS3",
                            "Curso completo de HTML5 e CSS3 para iniciantes",
                            "https://www.cursoemvideo.com/course/html5-css3-modulo1/",
                            "Curso em Vídeo", "40h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff105e")),

                    new Course("683d942a34268a3db560f778", "Crie um site simples usando HTML, CSS e JavaScript",
                            "Desenvolvimento web front-end básico",
                            "https://www.ev.org.br/cursos/crie-um-site-simples-usando-html-css-e-javascript",
                            "Fundação Bradesco - Escola Virtual", "10h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff105e")),

                    new Course("683d942a34268a3db560f779", "Desenvolvedor Web Front-End",
                            "Formação completa em desenvolvimento front-end",
                            "https://www.ev.org.br/cursos/desenvolvedor-web-front-end",
                            "Fundação Bradesco - Escola Virtual", "72h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff105e")),

                    new Course("683d942a34268a3db560f77a", "HTML5 e CSS3 Básico",
                            "Fundamentos de HTML5 e CSS3",
                            "https://www.primecursos.com.br/html5-css3/",
                            "Prime Cursos", "30h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff105e")),

                    new Course("683d942a34268a3db560f77b", "React do Zero ao Avançado",
                            "Curso completo de React.js",
                            "https://www.ev.org.br/cursos/introducao-ao-react",
                            "Fundação Bradesco - Escola Virtual", "20h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff105f")),

                    new Course("683d942a34268a3db560f77c", "Vue.js para Iniciantes",
                            "Fundamentos do framework Vue.js",
                            "https://www.primecursos.com.br/vuejs/",
                            "Prime Cursos", "25h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff105f")),

                    new Course("683d942a34268a3db560f77d", "Angular Básico",
                            "Introdução ao framework Angular",
                            "https://www.ev.org.br/cursos/introducao-ao-angular",
                            "Fundação Bradesco - Escola Virtual", "30h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff105f")),

                    new Course("683d942a34268a3db560f77e", "Python para Iniciantes",
                            "Fundamentos de Python incluindo estruturas de controle",
                            "https://www.cursoemvideo.com/course/python-3-mundo-1/",
                            "Curso em Vídeo", "40h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff1061")),

                    new Course("683d942a34268a3db560f77f", "APIs RESTful com Node.js",
                            "Criação e consumo de APIs REST",
                            "https://www.ev.org.br/cursos/nodejs-api-rest",
                            "Fundação Bradesco - Escola Virtual", "25h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff1063", "683d7c45c0adeb1f83ff1068")),

                    new Course("683d942a34268a3db560f780", "Desenvolvimento de APIs",
                            "Fundamentos para criação de APIs",
                            "https://www.primecursos.com.br/desenvolvimento-apis/",
                            "Prime Cursos", "20h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff1063")),

                    new Course("683d942a34268a3db560f781", "Python para Web - APIs",
                            "Criação de APIs com Python",
                            "https://www.cursoemvideo.com/course/python-3-mundo-3/",
                            "Curso em Vídeo", "40h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff1063")),

                    new Course("683d942a34268a3db560f782", "Curso de MySQL",
                            "Fundamentos de banco de dados MySQL",
                            "https://www.cursoemvideo.com/course/mysql/",
                            "Curso em Vídeo", "40h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff1064")),

                    new Course("683d942a34268a3db560f783", "Modelagem de Dados",
                            "Conceitos de modelagem e design de banco de dados",
                            "https://www.ev.org.br/cursos/modelagem-de-dados",
                            "Fundação Bradesco - Escola Virtual", "15h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff1064")),

                    new Course("683d942a34268a3db560f784", "SQL Server - Básico",
                            "Fundamentos do SQL Server",
                            "https://www.ev.org.br/cursos/microsoft-sql-server-2016-basico",
                            "Fundação Bradesco - Escola Virtual", "20h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff1064")),

                    new Course("683d942a34268a3db560f785", "PostgreSQL Básico",
                            "Introdução ao PostgreSQL",
                            "https://www.primecursos.com.br/postgresql/",
                            "Prime Cursos", "25h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff1064")),

                    new Course("683d942a34268a3db560f786", "Java para Iniciantes",
                            "Fundamentos de Java incluindo estruturas de controle",
                            "https://www.ev.org.br/cursos/java-basico",
                            "Fundação Bradesco - Escola Virtual", "30h", DifficultyLevel.BEGINNER,
                            List.of("683d7c45c0adeb1f83ff1066")),

                    new Course("683d942a34268a3db560f787", "Desenvolvimento de APIs Mobile",
                            "APIs para aplicações mobile",
                            "https://www.primecursos.com.br/desenvolvimento-apis-mobile/",
                            "Prime Cursos", "30h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff1068")),

                    new Course("683d942a34268a3db560f788", "Desenvolvimento Android",
                            "Criação de apps nativos para Android",
                            "https://www.ev.org.br/cursos/desenvolvimento-android",
                            "Fundação Bradesco - Escola Virtual", "40h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff1069")),

                    new Course("683d942a34268a3db560f789", "Java para Android",
                            "Programação Java aplicada ao desenvolvimento Android",
                            "https://www.primecursos.com.br/java-android/",
                            "Prime Cursos", "35h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff1069")),

                    new Course("683d942a34268a3db560f78a", "Kotlin para Android",
                            "Desenvolvimento Android com Kotlin",
                            "https://www.ev.org.br/cursos/kotlin-android",
                            "Fundação Bradesco - Escola Virtual", "30h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff1069")),

                    new Course("683d942a34268a3db560f78b", "Git Avançado para DevOps",
                            "Git aplicado a práticas DevOps",
                            "https://www.ev.org.br/cursos/git-devops",
                            "Fundação Bradesco - Escola Virtual", "25h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff106a")),

                    new Course("683d942a34268a3db560f78c", "Introdução ao DevOps",
                            "Fundamentos de DevOps e integração contínua",
                            "https://www.ev.org.br/cursos/introducao-devops",
                            "Fundação Bradesco - Escola Virtual", "30h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff106b")),

                    new Course("683d942a34268a3db560f78d", "Docker para Iniciantes",
                            "Containerização com Docker",
                            "https://www.primecursos.com.br/docker/",
                            "Prime Cursos", "25h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff106b")),

                    new Course("683d942a34268a3db560f78e", "Jenkins CI/CD",
                            "Automação de deploy com Jenkins",
                            "https://www.ev.org.br/cursos/jenkins-cicd",
                            "Fundação Bradesco - Escola Virtual", "20h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff106b")),

                    new Course("683d942a34268a3db560f78f", "Monitoramento de Sistemas",
                            "Observabilidade em sistemas de produção",
                            "https://www.ev.org.br/cursos/monitoramento-sistemas",
                            "Fundação Bradesco - Escola Virtual", "20h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff106c")),

                    new Course("683d942a34268a3db560f790", "Linux para DevOps",
                            "Administração Linux aplicada ao DevOps",
                            "https://www.cursoemvideo.com/course/linux/",
                            "Curso em Vídeo", "20h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff106c")),

                    new Course("683d942a34268a3db560f791", "Logs e Análise de Performance",
                            "Gerenciamento de logs e análise de performance",
                            "https://www.primecursos.com.br/logs-performance/",
                            "Prime Cursos", "15h", DifficultyLevel.INTERMEDIATE,
                            List.of("683d7c45c0adeb1f83ff106c"))
            );

            courseRepository.saveAll(courses);
            System.out.println("Courses seeded successfully!");
        }
    }
}

