from flask import Flask, redirect

servidor1 = Flask(__name__)

@servidor1.route("/")
def hola():
    return redirect('https://www.android.com/intl/es_es/', code=302)

if __name__ == '__main__':
    servidor1.run(host="0.0.0.0")