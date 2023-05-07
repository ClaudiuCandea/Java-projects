import airplane from './images/airplane.png'
import "./HomeBody.css"

function HomeBody() {
    return (
        <div className = "hbody">
            <div className = "bodyframe">
                <div className = 'bodytext'>
                    <h1 className = 'texth1'> 6 continents, </h1>
                    <h1 className = 'texth1'> endless posibilities. </h1>
                    <p className = 'textp'> It's time to take the trip you've always dreamed of. </p>
                </div>
                <div className = "bodypicture">
                    <img src = {airplane} className = "plane" alt = 'airplane'></img>
                </div>
            </div>
        </div>
    )
}

export default HomeBody