import queue
import time
from student import Student

student_queue = queue.Queue()

student_queue.put(1, "Angela")
student_queue.put(2, "Pedro")
student_queue.put(3, "Joao")

print("Exibindo fila: ")
for item in student_queue.queue:
    print(item)

print("Showing head: ")
print(student_queue.queue[0])

print("Showing end of queue: ")
print(student_queue.queue[-1])

print("Checking if queue is empty: ")
print(student_queue.empty())

print("Size: ")
print(student_queue.qsize())    

print("Checking if i am in the queue: ")
a = Student(1,"Angela")
print(a in student_queue.queue)

while (not student_queue.empty()):
    print("Removing ...")
    print(str(student_queue.get_nowait()))
    time.sleep(1)