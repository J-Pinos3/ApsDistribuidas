from flask import Flask, redirect

servidor5= Flask(__name__)

@servidor5.route("/")
def hola():
    return redirect('https://www.youtube.com/watch?v=qtwBFz6lfrY', code=302)

if __name__ == '__main__':
    servidor5.run(host="0.0.0.0")