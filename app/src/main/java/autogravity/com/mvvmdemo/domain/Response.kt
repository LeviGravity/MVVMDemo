package autogravity.com.mvvmdemo.domain

class Response<T> private constructor(val status: Status, val data: T?, val throwable: Throwable?) {
    companion object {

        fun <T> loading(): Response<T> {
            return Response(Status.LOADING, null, null)
        }

        fun <T> success(data: T): Response<T> {
            return Response(Status.SUCCESS, data, null)
        }

        fun <T> error(t: Throwable, data: T?): Response<T> {
            return Response(Status.ERROR, data, t)
        }
    }
}
