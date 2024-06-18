import { useNavigate } from "react-router-dom";
import "./Home.css"

const Home = ()=>{

    const navigate = useNavigate();
    const navigateCarsList=()=>{
        navigate("/cars/all");
    }
    return <div className="home">
        <h1>This is the home page of the Car Show</h1>
        <button onClick={()=>{navigateCarsList()}}>View our Cars</button>
    </div>
}

export default Home;