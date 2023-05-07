import logo from './images/placeholderlogo.png'
import Button from "react-bootstrap/Button";
import "./Header.css"

export default function Header(props) {
    return (
        <div className = "header">
            <div className = "headerbody">
                <img src = {logo} className = "logo" alt = "Logo"></img>
            </div>
            <Button className = "logout" onClick = {() => props.disconnect(false)} type = "submit">
                LogOut
            </Button>
        </div>
    )
}