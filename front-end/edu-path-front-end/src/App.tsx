import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "./App.css";
import AuthForm from "./components/Auth/AuthForm";
import { Header } from "./components/Header";
import { Footer } from "./components/Footer";
import CourseList from "./pages/Courses/CourseList";
import CourseDetail from "./pages/Courses/CourseDetail";
import Profile from "./pages/Profile/Profile";
import RoadmapList from "./pages/Roadmaps/RoadmapList";
import RoadmapDetail from "./pages/Roadmaps/RoadmapDetail";

function App() {
  return (
    <Router>
      <div className="min-h-screen flex flex-col bg-white dark:bg-gray-900">
        <Header />
        <main className="flex-grow">
          <Routes>
            <Route path="/" element={<RoadmapList />} />
            <Route path="/login" element={<AuthForm />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/roadmaps" element={<RoadmapList />} />
            <Route path="/roadmaps/:id" element={<RoadmapDetail />} />
            <Route path="/courses" element={<CourseList />} />
            <Route path="/courses/:id" element={<CourseDetail />} />
            {/* Outras rotas serão adicionadas aqui posteriormente */}
          </Routes>
        </main>
        <Footer />
      </div>
    </Router>
  );
}

export default App;
