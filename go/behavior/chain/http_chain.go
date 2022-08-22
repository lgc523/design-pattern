package main

import (
	"context"
	"fmt"
	"log"
	"net/http"
	"time"
)

func main() {
	http.HandleFunc("/", Chain(Hello, Method("GET"), Logging()))
	http.HandleFunc("/auth", Chain(Auth, Method("GET"), GetAuthCode(), EnsureAuth(), Logging()))
	log.Panicln(http.ListenAndServe(":7878", nil))
}

type Middleware func(handlerFunc http.HandlerFunc) http.HandlerFunc

func GetAuthCode() Middleware {
	return func(f http.HandlerFunc) http.HandlerFunc {
		return func(w http.ResponseWriter, r *http.Request) {
			code := -1
			if r.URL.Path != "/" {
				code = 0
			}
			ctxWithUser := context.WithValue(r.Context(), code, "spider")
			rWithUser := r.WithContext(ctxWithUser)
			f(w, rWithUser)
		}
	}
}

func EnsureAuth() Middleware {
	return func(f http.HandlerFunc) http.HandlerFunc {
		return func(w http.ResponseWriter, r *http.Request) {
			user := r.Context().Value(0)
			if user != nil {
				log.Println("auth available")
			} else {
				http.Error(w, "please login in!", http.StatusUnauthorized)
				return
			}
			f(w, r)
		}
	}
}

func Logging() Middleware {
	return func(f http.HandlerFunc) http.HandlerFunc {
		return func(w http.ResponseWriter, r *http.Request) {
			start := time.Now()
			defer func() {
				log.Println(r.URL.Path, time.Since(start))
			}()
			f(w, r)
		}
	}
}

func Method(m string) Middleware {
	return func(f http.HandlerFunc) http.HandlerFunc {
		return func(w http.ResponseWriter, r *http.Request) {
			log.Println("request method is :", m)
			if r.Method != m {
				http.Error(w, http.StatusText(http.StatusBadRequest), http.StatusBadRequest)
				return
			}
			f(w, r)
		}
	}
}

func Chain(f http.HandlerFunc, middlewares ...Middleware) http.HandlerFunc {
	for _, m := range middlewares {
		f = m(f)
	}
	return f
}

func Hello(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "hello,您的外卖到了!")
}

func Auth(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "You are authorized!")
}
