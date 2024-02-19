#IMAGEN
FROM python:3.10.2

#DIRECTORIO DE TRABAJO
WORKDIR /Servidor4

# host -> contenedor
#/PracticaBalanceoCarga /servidor
COPY servidor4.py .

#DEPENDENCIAS
RUN pip install flask

#PUERTO DEL CONTENEDOR
#EXPOSE 5000

#EJECUTAR APP
CMD ["python3", "servidor4.py"]