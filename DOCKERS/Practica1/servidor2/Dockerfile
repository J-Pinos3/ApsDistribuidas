#IMAGEN
FROM python:3.10.2

#DIRECTORIO DE TRABAJO
WORKDIR /servidor2

# host -> contenedor
#/Practica1 /servidor
COPY . .

#DEPENDENCIAS
RUN pip install flask

#PUERTO DEL CONTENEDOR
EXPOSE 5001

#EJECUTAR APP
CMD ["python3", "app2.py"]