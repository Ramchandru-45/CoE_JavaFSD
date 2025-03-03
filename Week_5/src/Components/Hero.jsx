import React from "react";
import hero_img from '../assets/hero.png';

const Hero = () => {
    return (
        <div>
            <div className="grid w-full place-items-center bg-black py-10">
                <div className="text-center max-w-3xl">
                    <h1 className="text-5xl font-bold mt-10 text-white">
                        Experiance the Game<br /> With Virtual World
                    </h1>
                    <p className="text-lg mt-3 text-white">
                    Games4U offers top rated games that have every genre you ask, <br />featuring unique collections, secure gameboot, and an intuitive user interface..
                    </p>
                    <img src={hero_img} alt="Hero Image" className="w-[740px] h-[400px] mt-10 place-self-center" />
                </div>
            </div>
        </div>
    );
};

export default Hero;

