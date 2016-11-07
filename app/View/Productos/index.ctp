<div class="productos index">
	<h2><?php echo __('Productos'); ?></h2>
	<table cellpadding="0" cellspacing="0">
	<thead>
	<tr>
			<th><?php echo $this->Paginator->sort('id'); ?></th>
			<th><?php echo $this->Paginator->sort('nome'); ?></th>
			<th><?php echo $this->Paginator->sort('sku'); ?></th>
			<th><?php echo $this->Paginator->sort('quantidade'); ?></th>
			<th><?php echo $this->Paginator->sort('descricao'); ?></th>
			<th><?php echo $this->Paginator->sort('foto'); ?></th>
			<th><?php echo $this->Paginator->sort('referencia'); ?></th>
			<th><?php echo $this->Paginator->sort('preco_aquisicao'); ?></th>
			<th><?php echo $this->Paginator->sort('data_de_registo'); ?></th>
			<th><?php echo $this->Paginator->sort('estoque_minimo'); ?></th>
			<th><?php echo $this->Paginator->sort('data_de_validade'); ?></th>
			<th class="actions"><?php echo __('Actions'); ?></th>
	</tr>
	</thead>
	<tbody>
	<?php foreach ($productos as $producto): ?>
	<tr>
		<td><?php echo h($producto['Producto']['id']); ?>&nbsp;</td>
		<td><?php echo h($producto['Producto']['nome']); ?>&nbsp;</td>
		<td><?php echo h($producto['Producto']['sku']); ?>&nbsp;</td>
		<td><?php echo h($producto['Producto']['quantidade']); ?>&nbsp;</td>
		<td><?php echo h($producto['Producto']['descricao']); ?>&nbsp;</td>
		<td><?php echo h($producto['Producto']['foto']); ?>&nbsp;</td>
		<td><?php echo h($producto['Producto']['referencia']); ?>&nbsp;</td>
		<td><?php echo h($producto['Producto']['preco_aquisicao']); ?>&nbsp;</td>
		<td><?php echo h($producto['Producto']['data_de_registo']); ?>&nbsp;</td>
		<td><?php echo h($producto['Producto']['estoque_minimo']); ?>&nbsp;</td>
		<td><?php echo h($producto['Producto']['data_de_validade']); ?>&nbsp;</td>
		<td class="actions">
			<?php echo $this->Html->link(__('View'), array('action' => 'view', $producto['Producto']['id'])); ?>
			<?php echo $this->Html->link(__('Edit'), array('action' => 'edit', $producto['Producto']['id'])); ?>
			<?php echo $this->Form->postLink(__('Delete'), array('action' => 'delete', $producto['Producto']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $producto['Producto']['id']))); ?>
		</td>
	</tr>
<?php endforeach; ?>
	</tbody>
	</table>
	<p>
	<?php
	echo $this->Paginator->counter(array(
		'format' => __('Page {:page} of {:pages}, showing {:current} records out of {:count} total, starting on record {:start}, ending on {:end}')
	));
	?>	</p>
	<div class="paging">
	<?php
		echo $this->Paginator->prev('< ' . __('previous'), array(), null, array('class' => 'prev disabled'));
		echo $this->Paginator->numbers(array('separator' => ''));
		echo $this->Paginator->next(__('next') . ' >', array(), null, array('class' => 'next disabled'));
	?>
	</div>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('New Producto'), array('action' => 'add')); ?></li>
	</ul>
</div>
