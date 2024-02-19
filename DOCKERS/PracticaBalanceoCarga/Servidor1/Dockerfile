#IMAGEN
FROM python:3.10.2

#DIRECTORIO DE TRABAJO
WORKDIR /Servidor1

# host -> contenedor
#/PracticaBalanceoCarga /servidor TODOS LOS SERVIDORES FUNCIONAN COMO UNO SOLO
COPY servidor1.py .

#DEPENDENCIAS
RUN pip install flask

#PUERTO DEL CONTENEDOR
#EXPOSE 5000

#EJECUTAR APP
CMD ["python3", "servidor1.py"]