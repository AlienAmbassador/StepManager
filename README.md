# StepManager
Возьмите шагомер из прошлого задания. Сделайте класс StepBattle, который принимает два шагомера и имеет методы:

`addSteps(int player, int day, int steps)`, который добавляет шаги в первый или второй шагомер (номер определяется первым параметром, либо 1, либо 2).

`int winner()`, возвращающий номер выигравшего игрока - тот, у кого больше всех было шагов в сумме.

Протестируйте этот менеджер с помощью мокито. Вот зависимость:

```
<dependency>
<groupId>org.mockito</groupId>
<artifactId>mockito-junit-jupiter</artifactId>
<version>3.6.28</version>
<scope>test</scope>
</dependency>
```