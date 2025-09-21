from PIL import Image
import os

folder = r"C:\Users\pc\eclipse-workspace\Memrise-Project\TestMemrise\screenshots"
max_size = (360, 640)

for filename in os.listdir(folder):
    if filename.lower().endswith((".png", ".jpg", ".jpeg")):
        img_path = os.path.join(folder, filename)
        img = Image.open(img_path)
        img.thumbnail(max_size)
        img.save(img_path, optimize=True, quality=65)

print("All images resized smaller in 'screenshots'")
