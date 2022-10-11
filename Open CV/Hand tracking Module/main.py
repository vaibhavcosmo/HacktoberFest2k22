import cv2
from cvzone.HandTrackingModule import HandDetector

cap = cv2.VideoCapture(0)

while True:
    success , img = cap.read()
    cv2.imshow("Image",img)
    cv2.waitKey(1)
