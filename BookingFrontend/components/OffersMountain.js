import React, { useState, useEffect } from 'react';
import pointer from './images/map-pointer.png';
import './Offers.css';

export default function OffersBeach(props) {
    const { userType } = props;
    const [offers, setOffers] = useState( []);
    const [ numberNights, setNumberNights ] = useState('');

    useEffect(() => {
        fetch('api/v1/hotel/getHotels')
          .then(response => response.json())
          .then(data => {
            setOffers(data.filter(i=> i.type === 'mountain'));
          })
      }, []);

    const handleDelete = async (id) => {
        {
            await fetch(`api/v1/hotel/deleteHotel/${id}`, {
                method: 'DELETE',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            }).then(() => {
                let updatedOffers = [...offers].filter(i => i.id !== id);
                setOffers(updatedOffers);
            });
        }
    }

    const handleBook = async (id,name,price,noNights) => {
        console.log(noNights);
        await fetch('api/v1/Reservation/addReservation',{
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
              userID: props.userID,
              hotelID: id,
              hotelName: name,
              totalPrice : price,
              noNight: noNights,
            }),
        });
        }

    

    return (
        <div className = "body">
            <div className = "mainbody">
                <div className = "listoffers">
                    {offers.map((offer) => (
                        <div className = "offerbody" key = {offer.id}>
                            <div className = "locationimage">
                                <img src = {require(`./images/${offer.imagePathLocation}`)}></img>
                            </div>
                            <div className = "locationdetails">
                                <div className = "location">
                                    <img src = {pointer} alt = 'pointer'></img>
                                    <span className = "countryOffer"> {offer.address} </span>
                                </div>
                                <h1 className = "locationname"> {offer.name} </h1>
                                <h4 className = "infotext">
                                    <label> Price per night </label>
                                    {offer.pricePerNight}
                                </h4>
                                <p className = "description">
                                    {offer.description}
                                </p>
                                <h4 className = "infotext">
                                    <label> Number of Nights </label>
                                    <input type = "numberNights" onChange = {(e) => setNumberNights(e.target.value)}></input>
                                </h4>
                                <h4 className = "infotext">
                                    <label> Number of free rooms </label>
                                    {offer.noFreeRooms}
                                </h4>
                                {
                                    userType === "client" ? (
                                        <button className = 'button' onClick = {() => handleBook(offer.id, offer.name, offer.pricePerNight,numberNights)}> BOOK RESERVATION </button>
                                    ) :
                                    userType === "admin" ? (
                                        <button className = 'button' onClick = {() => handleDelete(offer.id)}> REMOVE </button>
                                    ) :
                                    <></>
                                }
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    )
}