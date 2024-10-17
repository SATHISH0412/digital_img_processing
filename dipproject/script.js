


import { readFileSync } from "fs";

// Load the image in base64 format
const image = readFileSync("person.jpg", { encoding: "base64" });

// Define the fetch function to make the POST request
async function detectHumanRace() {
    const url = "https://detect.roboflow.com/human-race-detection/7?api_key=lkpgUV1J2gLNxrCWEn6b";

    try {
        const response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                image: image  // Send the base64 encoded image
            })
        });

        // Check if the response is okay
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        console.log("Detection Results:", data);
    } catch (error) {
        console.error("Error:", error.message);
    }
}

// Call the function to detect human race
detectHumanRace();

