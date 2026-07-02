from flask import Flask, jsonify
import logging

app = Flask(__name__)

# Configuramos el logging para que los mensajes salgan a la consola (y Docker los capture)
logging.basicConfig(level=logging.INFO)

@app.route('/')
def hola_mundo():
    app.logger.info("Se ha accedido a la ruta principal /")
    return "¡Hola Mundo desde AWS y Docker!"

@app.route('/health')
def health_check():
    # Este endpoint servirá para que AWS sepa si el servicio está vivo (Disponibilidad)
    return jsonify({"status": "ok", "message": "Servicio funcionando correctamente"}), 200

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)