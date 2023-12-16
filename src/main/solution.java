// пример кода с ковариантностью
class Animal {}

class Cat extends Animal {}

class AnimalContainer<T extends Animal> {}

class CatContainer extends AnimalContainer<Cat> {}


// пример кода с контравариантностью
class UniversalList {}

class LinkedList extends UniversalList {}

class DelegateA<LinkedList>

class DelegateA<UniversalList> extends DelegateA<LinkedList> {}
