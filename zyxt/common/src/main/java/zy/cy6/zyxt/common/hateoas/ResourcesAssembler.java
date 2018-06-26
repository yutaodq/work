/*
 *spring-hateoas-examples
 */
package zy.cy6.zyxt.common.hateoas;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;

/**
 * Analogous to {@link ResourceAssembler} but for resource collections.
 *
 * @author Greg Turnquist
 */
public interface ResourcesAssembler<T, D extends ResourceSupport> {

  /**
   * Converts all given entities into resources and wraps the collection as a resource as well.
   *
   * @param entities must not be {@literal null}.
   * @return {@link Resources} containing {@link Resource} of {@code T}.
   * @see ResourceAssembler#toResource(Object)
   */
  Resources<D> toResources(Iterable<? extends T> entities);

}
