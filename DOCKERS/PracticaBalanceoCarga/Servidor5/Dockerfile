#IMAGEN
FROM python:3.10.2

#DIRECTORIO DE TRABAJO
WORKDIR /Servidor5

# host -> contenedor
#/PracticaBalanceoCarga /servidor
COPY servidor5.py .

#DEPENDENCIAS
RUN pip install flask

#PUERTO DEL CONTENEDOR
#EXPOSE 5000

#EJECUTAR APP
CMD ["python3", "servidor5.py"]