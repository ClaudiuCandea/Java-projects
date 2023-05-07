import React, { useState, useRef } from 'react';
import { Navigate } from "react-router";
import pointer from './images/map-pointer.png';
import { useDropzone } from 'react-dropzone';
import "./Admin.css"

function Admin(props) {
    const { loginStatus } = props;
    const [ dragActive, setDragActive ] = useState(false);
    const [ name, setName ] = useState('');
    const [ address, setAddress ] = useState('');
    const [ description, setDescription ] = useState('');
    const [ pricePerNight, setPrice ] = useState('');
    const [ noFreeRooms, setRooms ] = useState('');
    const [ type, setType ] = useState('');
    const [ imagePathLocation, setImage ] = useState([]);

    // const [yourImage, setImage] = useState([]);

    const {getRootProps, getInputProps, isDragActive} = useDropzone({
        accept : "image/*",
        onDrop : (acceptedFiles) => {
            setImage(
                acceptedFiles.map((upFile) => Object.assign(upFile, {
                    preview : URL.createObjectURL(upFile)
                }))
            )
        }
    })

    async function handleAdd() {
        console.log(name);
        console.log(address);
        console.log(imagePathLocation[0].name);

        await fetch("api/v1/hotel/addHotel", {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
              name: name,
              address: address,
              description: description,
              pricePerNight : pricePerNight,
              noFreeRooms: noFreeRooms,
              imagePathLocation: imagePathLocation[0].name,
              type: type,
            }),
        });
        // console.log("./images/" + imagePathLocation.map((upFile) => upFile.path));
    }

    return (
        <div>
            {
                loginStatus ? (
                    <div className = "bodyAdmin">
                        <h1> Add a new offer </h1>
                        <div className = 'droppedImage'>
                            <div {...getRootProps()}>
                                <input {...getInputProps()} />
                                {
                                    isDragActive ? (
                                        <p>
                                            Drop the Image here
                                        </p>
                                    ) : (
                                        <p>
                                            Drag 'n' drop the Image here || Click to select image
                                        </p>
                                    )
                                }
                            </div>
                            <div>
                                {imagePathLocation.map((upFile) => {
                                    return (
                                        <div>
                                            <img src = {upFile.preview} style = {{width : "50%", height : "50%", border : "3px solid #CCC"}} alt = "preview" />
                                        </div>
                                    )
                                })}
                            </div>
                        </div>
                        <div className = "locationdetails">
                            <div className = "location">
                                <img src = {pointer} alt = 'pointer'></img>
                                <input type = "country" onChange={(e) => setAddress(e.target.value)}></input>
                            </div>
                            <h4 className = "locationname">
                                <label> Hotel Name </label>
                                <input type = "location" onChange={(e) => setName(e.target.value)}></input>
                            </h4>
                            <h4 className = "infotext">
                                <label> Type </label>
                                <input type = "startDate" onChange={(e) => setType(e.target.value)}></input>
                            </h4>
                            <p className = "description">
                                <label> Description </label>
                                <input className = "descriptionBox" type = "description" onChange={(e) => setDescription(e.target.value)}></input>
                            </p>
                            <h4 className = "infotext">
                                <label> Price </label>
                                <input type = "price" onChange={(e) => setPrice(e.target.value)}></input>
                            </h4>
                            <h4 className = "infotext">
                                <label> Number of free Rooms </label>
                                <input type = "numberOfRooms" onChange={(e) => setRooms(e.target.value)}></input>
                            </h4>
                            <button className = "btnAdmin" onClick = {handleAdd}> ADD NEW OFFER </button>
                        </div>
                    </div>
                ) :
                <Navigate to = "/" />
            }
        </div>
    )
}

export default Admin;