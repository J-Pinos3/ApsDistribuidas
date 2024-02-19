from locust import HttpUser, task, between


class MyUser(HttpUser):
    wait_time = between(1,2)

    #normal mente se ponde el localhost, en este caso el contenedor
    @task
    def index(self):
        response = self.client.get("http://app:5000/")
    