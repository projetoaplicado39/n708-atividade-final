import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "./App.css";
import AuthForm from "./components/Auth/AuthForm";
import { Header } from "./components/Header";
import { Footer } from "./components/Footer";

function App() {
  return (
    <Router>
      <div className="min-h-screen flex flex-col bg-white dark:bg-gray-900">
        <Header />
        <main className="flex-grow">
          <Routes>
            <Route path="/" element={<AuthForm />} />
            {/* Outras rotas serão adicionadas aqui posteriormente */}
          </Routes>
        </main>
        <Footer />
      </div>
    </Router>
  );
}

export default App;
