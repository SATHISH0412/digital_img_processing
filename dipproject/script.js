const axios = require("axios");

axios({
    method: "POST",
    url: "https://detect.roboflow.com/human-race-detection/7",
    params: {
        api_key: "lkpgUV1J2gLNxrCWEn6b",
        image: "https://images.unsplash.com/photo-1502764613149-7f1d229e230f"  // Example image link
    }
})
.then(function(response) {
    console.log(response.data);  // Prints the detection results
})
.catch(function(error) {
    console.log(error.message);  // Prints any error that occurs
});
