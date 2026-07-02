# Usamos una imagen ligera de Python
FROM python:3.9-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiamos los archivos necesarios
COPY requirements.txt requirements.txt
COPY app.py app.py

# Instalamos las dependencias
RUN pip install --no-cache-dir -r requirements.txt

# Exponemos el puerto
EXPOSE 5000

# Comando para ejecutar la app
CMD ["python", "app.py"]