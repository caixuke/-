//已知memcpy的函数为： void* memcpy(void *dest , const void* src , size_t count)其中dest是目的指针，src是源指针。不调用c++/c的memcpy库函数，请编写memcpy。
void* memcpy(void *dst, const void *src, size_t count)
{
	//安全检查
	assert((dst != null) &&(src != null));
	unsigned char *pdst = (unsigned char *)dst;
	const unsigned char *psrc = (const unsigned char *)src;
	//防止内存重复
	assert(!(psrc <= pdst && pdst < psrc + count));
	assert(!(pdst <= psrc && psrc < pdst + count));

	while(count--)
	{
		*pdst = *psrc;
		pdst++;
		psrc++;
	}
	return dst;
}