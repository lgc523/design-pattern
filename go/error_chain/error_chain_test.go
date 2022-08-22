package error_chain

import (
	"errors"
	"fmt"
	"testing"
)

func TestErrorChain(t *testing.T) {
	err1 := errors.New("new error")
	err2 := fmt.Errorf("err2:[%w]", err1)
	err3 := fmt.Errorf("err3:[%w]", err2)
	fmt.Println(err3)
}

type WarpError struct {
	msg string
	err error
}

func (e *WarpError) Error() string {
	return e.msg
}

func (e *WarpError) Unwrap() error {
	return e.err
}

func TestUnwrap(t *testing.T) {
	err1 := errors.New("new error")
	err2 := fmt.Errorf("err2:[%w]", err1)
	err3 := fmt.Errorf("err3:[%w]", err2)
	fmt.Println(errors.Unwrap(err3))
	fmt.Println(errors.Unwrap(errors.Unwrap(err3)))
}

func TestErrorCheck(t *testing.T) {
	err1 := errors.New("new error")
	err2 := fmt.Errorf("err2:[%w]", err1)
	err3 := fmt.Errorf("err3:[%w]", err2)
	fmt.Println(errors.Is(err3, err2))
	fmt.Println(errors.Is(err3, err1))
}

type ErrorString struct {
	s string
}

func (e *ErrorString) Error() string {
	return e.s
}

func TestErrorsAs(t *testing.T) {
	var targetErr *ErrorString
	err := fmt.Errorf("new err:[%w]", &ErrorString{s: "target err"})
	fmt.Println(errors.As(err, &targetErr))
}
