from inference_sdk import InferenceHTTPClient
import opencv
from PIL import Image

# Initialize the client
CLIENT = InferenceHTTPClient(
    api_url="https://detect.roboflow.com",
    api_key="lkpgUV1J2gLNxrCWEn6b"
)

# Load the image
image_path = "/workspaces/digital_img_processing/dipproject/person.jpg"
image = Image.open(image_path)

# Perform inference
result = CLIENT.infer(image, model_id="human-race-detection/7")

# Print the result
print(result)
