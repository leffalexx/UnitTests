import pytest
from hw_6 import GivenLists


@pytest.fixture
def first_list():
    return [5, 16, 32, 11, 5]


@pytest.fixture
def second_list():
    return [99, -5, 7, 2, 4]


def test_initialisation(first_list, second_list):
    lists = GivenLists(first_list, second_list)
    assert lists.list_one == first_list
    assert lists.list_two == second_list


def test_find_list_avg(first_list, second_list):
    lists = GivenLists(first_list, second_list)
    assert lists.find_list_avg() == (13.8, 21.4)


def test_first_list_bigger(first_list, second_list, capfd):
    lists = GivenLists(second_list, first_list)
    lists.compare_list_avg()
    captured = capfd.readouterr()
    assert captured.out.strip() == f'Первый список имеет большее среднее значение'


def test_second_list_bigger(first_list, second_list, capfd):
    lists = GivenLists(first_list, second_list)
    lists.compare_list_avg()
    captured = capfd.readouterr()
    assert captured.out.strip() == f'Второй список имеет большее среднее значение'


def test_equal_lists_avg(first_list, capfd):
    lists = GivenLists(first_list, first_list)
    lists.compare_list_avg()
    captured = capfd.readouterr()
    assert captured.out.strip() == f'Средние значения равны'


@pytest.mark.parametrize('list_one, list_two, result', [([4, 5, 6], [], (5, 0)), ([], [4, 5, 6], (0, 5)),
                                                        ([], [], (0, 0))])
def test_empty_lists(list_one, list_two, result):
    lists = GivenLists(list_one, list_two)
    assert lists.find_list_avg() == result


@pytest.mark.parametrize('list_one, list_two, result', [([1, 2, 3], [1], (2, 1)), ([1], [1, 2, 3], (1, 2)),
                                                        ([1], [1], (1, 1))])
def test_single_element_list(list_one, list_two, result):
    lists = GivenLists(list_one, list_two)
    assert lists.find_list_avg() == result
