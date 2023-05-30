require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока

        
    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}
        

    state: /hello
        q!: *start*
        q!: * (привет/здравствуй*/~добрый (~день/~утро/~вечер/~ночь)) *
        random:
            a: Привет!
            a: Рад приветствовать!
            a: Добрый день!
        

    state: /weather
        q!: *(какая * погода)*
        random:
            a: Конечно! Сегодня солнечно, 23 градуса, ветер 3 м/с
            a: Прогноз погоды на сегодня – сегодня солнечно, 23 градуса, ветер 3 м/с
            a: Погода в Санкт-Петербурге на сегодня: солнечно, 23 градуса, ветер 3 м/с


    state: /currency
        q!: *(~какой курс/курс * к */сколько стоит/курс)*