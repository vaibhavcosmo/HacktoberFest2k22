from flask import Flask
from threading import Thread

HOST = '0.0.0.0'
PORT = '8080'

app = Flask('')


# bot main
@app.route('/')
def home():
    return "Hello. I am alive!"

def run_app():
  app.run(host = HOST, port = PORT)

# run the app
def keep_alive():
    t = Thread(target=run_app)
    t.start()
