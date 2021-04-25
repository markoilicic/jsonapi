package com.jsonapi.internal.factory

import com.jsonapi.Resource
import com.jsonapi.TestUtils.factory
import com.jsonapi.TestUtils.moshi
import com.jsonapi.internal.adapter.ResourceAdapter
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ResourceFactoryTest {

  private val resourceFactory = ResourceFactory(emptyList(), emptyList(), false)

  @Test
  fun `returns adapter when type is Resource`() {
    val type = Resource::class.java
    val adapter = resourceFactory.create(type, mutableSetOf(), moshi, factory)
    assertThat(adapter).isInstanceOf(ResourceAdapter::class.java)
  }

  @Test
  fun `returns null when type is not Resource`() {
    val type = Any::class.java
    val adapter = resourceFactory.create(type, mutableSetOf(), moshi, factory)
    assertThat(adapter).isNull()
  }
}
