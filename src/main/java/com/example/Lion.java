package com.example;

import java.util.List;

publicpublic class Lion {
    private boolean hasMane;
    private Feline feline;

    /**
     * Конструктор льва с указанием пола и экземпляра Feline.
     * @param sex Пол животного: "Самец" или "Самка"
     * @param feline Экземпляр Feline для внедрения зависимости
     * @throws Exception Если указан недопустимый пол
     */
    public Lion(String sex, Feline feline) throws Exception {
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.feline = feline;
    }

    /**
     * Возвращает количество львят.
     * @return Количество львят (делегирует вызов Feline)
     */
    public int getKittens() {
        return feline.getKittens();
    }

    /**
     * Проверяет, есть ли у льва грива.
     * @return true, если лев — самец, иначе false
     */
    public boolean doesHaveMane() {
        return hasMane;
    }

    /**
     * Возвращает список пищи для льва.
     * @return Список продуктов питания (делегирует вызов Feline)
     * @throws Exception Если произошла ошибка при получении пищи
     */
    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
