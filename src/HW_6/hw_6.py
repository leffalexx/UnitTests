# Создайте программу на Python или Java, которая принимает два списка чисел и выполняет следующие действия:
# a. Рассчитывает среднее значение каждого списка.
# b. Сравнивает эти средние значения и выводит соответствующее сообщение:
# - ""Первый список имеет большее среднее значение"", если среднее значение первого списка больше.
# - ""Второй список имеет большее среднее значение"", если среднее значение второго списка больше.
# - ""Средние значения равны"", если средние значения списков равны.

class GivenLists:
    def __init__(self, list_one: list[int], list_two: list[int]):

        self.list_one = list_one
        self.list_two = list_two

    def find_list_avg(self) -> tuple[float, float]:

        first_list_avg = 0
        second_list_avg = 0

        if self.list_one:
            first_list_avg = sum(self.list_one) / len(self.list_one)
        if self.list_two:
            second_list_avg = sum(self.list_two) / len(self.list_two)
        return first_list_avg, second_list_avg

    def compare_list_avg(self):

        first_list_avg, second_list_avg = self.find_list_avg()

        if first_list_avg > second_list_avg:
            print(f'Первый список имеет большее среднее значение')
        elif first_list_avg < second_list_avg:
            print(f'Второй список имеет большее среднее значение')
        else:
            print(f'Средние значения равны')
