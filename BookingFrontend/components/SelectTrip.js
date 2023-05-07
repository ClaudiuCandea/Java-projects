import beach from './images/beachBtn.svg'
import mountain from './images/mountainBtn.png'
import city from './images/cityBtn.png'
import {Link} from "react-router-dom"
import "./SelectTrip.css"

function SelectTrip() {
    return (
        <div className = "buttonsM">
            <div className = "buttonsgrid">
                <div className = "buttonframe">
                    <div className = "buttonbody">
                        <img src = {beach} className = "buttonpicture" alt = 'beach'></img>
                        <Link to ="/OffersBeach">
                        <p className = 'buttontext'> Beach </p>
                        </Link>
                    </div>
                </div>
                <div className = "buttonframe">
                    <div className = "buttonbody">
                        <img src = {mountain} className = "buttonpicture" alt = 'mountain'></img>
                        <Link to ="/OffersMountain">
                        <p className = 'buttontext'> Mountain </p>
                        </Link>
                    </div>
                </div>
                <div className = "buttonframe">
                    <div className = "buttonbody">
                        <img src = {city} className = "buttonpicture" alt = 'city'></img>
                        <Link to ="/OffersCity">
                        <p className = 'buttontext'> City Break </p>
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default SelectTrip