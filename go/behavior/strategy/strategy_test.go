package strategy

import (
	"fmt"
	"testing"
)

type Strategy interface {
	sendMsg()
}

type FooStrategy struct {
}

func (f FooStrategy) sendMsg() {
	fmt.Println("fooStrategy sendMsg.")
}

type BarStrategy struct {
}

func (b BarStrategy) sendMsg() {
	fmt.Println("barStrategy sendMsg.")
}

type StrategyType interface {
	FooStrategy | BarStrategy
}

var m = map[string]Strategy{
	"Foo": &FooStrategy{},
	"Bar": &BarStrategy{},
}

func TestStrategy(t *testing.T) {
	strategy, ok := m["Foo"]
	if ok {
		strategy.sendMsg()
	}
}
